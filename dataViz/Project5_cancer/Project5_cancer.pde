// Data Visualization
// Group project 2 - Week 5/6 
// Fall Term 2 - 2019
// Elyse Weldon, Ryan Wade and Christina Morgenstern


FloatTable data;  // Data table
float dataMin, dataMax;  // Minimum and maximum value

float plotX1, plotY1;  // First plot position
float plotX2, plotY2;  // Second plot position
float labelX, labelY;  // Label position

// Mouse wheel data
float mx, my, ratio, xpt, ypt, xzt, yzt, swt, zoom;

int rowCount;  // Row counter
int columnCount;  // Columns counter
int currentColumn = 0;  // Current column selected

int yearMin, yearMax;  // Minimum and maximum year
int[] years;           // Year vector

int yearInterval = 10;  // Years inteval of time
int deathInterval = 500;
int deathIntervalMin = 100;

float[] tabLeft, tabRight;  // Tabs positions on left and right
float tabTop, tabBottom;    // Tabs position on top and bottom
float tabPad = 10;          // Tabs padding        

Integrator[] interpolators;

PFont plotFont;  // Font 

boolean[] columnsSelected;  // Columns selected
color[] columnsColors = {  // Columns colors
  #1D5ECB, 
  #1E762F, 
  #3E300B
};

// Scroll position
float scrollTop, scrollBottom;
float scrollLeft, scrollRight;

float scrollBarX;  // Scroll bar position
float scrollBarWidth;  // Bar width
float scrollPercent;  //  Scroll porcent


// set up window and zoom functions
void setup() {
  size(720,405);
  // Init. mouse wheel values
  zoom=1.0;
  mx=width/60;
  my=mx*height/width;
  ratio=mx/my;

  // Import and parse data
  data = new FloatTable("cancer_data_Austria2.tsv");
  rowCount = data.getRowCount();  
  columnCount = data.getColumnCount();

  // Save list of years, save the minimum and maximum
  years = int(data.getRowNames());
  yearMin = years[0];
  yearMax = years[years.length - 1];

  // Set data minimum and maximum
  dataMin = 0;
  dataMax = ceil(data.getTableMax() / deathInterval) * deathInterval;;

  // Init. integrators
  interpolators = new Integrator[rowCount];
  for (int row = 0; row < rowCount; row++) {
    float initialValue = data.getFloat(row, 0);
    interpolators[row] = new Integrator(initialValue);
    interpolators[row].attraction = 0.1;  // Set lower than the default
  }

  // Set plot and label position
  plotX1 = 120;
  plotX2 = width - 80;
  labelX = 50;
  plotY1 = 60;
  plotY2 = height - 70;
  labelY = height - 25;

  // Init. list columns selected
  columnsSelected = new boolean[columnCount];

  // Set scroll position
  scrollTop = height-40;
  scrollBottom = height;
  scrollLeft = 0;
  scrollRight = width;

  // Set scroll bar values
  scrollBarWidth = 80;
  scrollBarX = scrollBarWidth/2;
  scrollPercent = map(scrollBarX, scrollBarWidth/2, scrollRight-scrollBarWidth/2, 0, 100);

  // Load font and set
  plotFont = createFont("SansSerif", 20);
  textFont(plotFont);

  // Set color mode
  colorMode(ARGB, 255, 255, 255, 100);

  // Use smooth
  smooth();
}


void draw() {
  // Set up plot area for zoom capability
  background(224);
  pushMatrix();
  scale(zoom);
  translate(xpt-xzt-((scrollPercent/100)*width), ypt-yzt);

  // Show the plot area as a white box  
  fill(255);
  rectMode(CORNERS);
  noStroke();
  rect(plotX1, plotY1, plotX2, plotY2);
  
  // draw supertitle
  fill(0);
  textSize(20);
  textAlign(CENTER);
  text("Female Cancer Statistics Austria", 360, 20);

  // Draw tabs
  DrawTitleTabs();
  // Draw labels
  DrawAxisLabels();

  // Update interpolators
  for (int row = 0; row < rowCount; row++) {
    interpolators[row].update();
  }

  // Draw years
  DrawYearLabels();
  // Draw volume interval
  DrawDeathLabels();

  // Draw lines and highlights 
  noFill();
  strokeWeight(5);
  for (int row=0; row<columnCount; row++) {
    DrawDataLine(row);
    if (columnsSelected[row]) {
      DrawDataHighlight(row);
    }
  }
  popMatrix();
  
  // Draw scroll bar
  DrawScrollBar();
}

void DrawScrollBar() {
  // Move the scroll bar to mouse position and calculate percent
  if (mousePressed) {
    if (mouseButton == LEFT) {
      if (mouseX>scrollLeft && mouseX<scrollRight) {
        if (mouseY>scrollTop && mouseY<scrollBottom) {
          scrollBarX = mouseX;
          if (scrollBarX<scrollBarWidth/2) {
            scrollBarX = scrollBarWidth/2;
          } else if (scrollBarX>scrollRight-scrollBarWidth/2) {
            scrollBarX = scrollRight-scrollBarWidth/2;
          }
          scrollPercent = map(scrollBarX, scrollBarWidth/2, scrollRight-scrollBarWidth/2, 0, 100);
        }
      }
    }
  }
  
  // Draw scroll
  stroke(50, 20);
  strokeWeight(4);
  fill(200);
  rectMode(CORNER);
  rect(scrollLeft, scrollTop, scrollRight, scrollBottom - scrollTop);
  
  // Draw bar
  rectMode(CENTER);
  fill(250);
  rect(scrollBarX, scrollBottom-(scrollBottom - scrollTop)/2, scrollBarWidth, scrollBottom - scrollTop);
}


void DrawTitleTabs() {
  rectMode(CORNERS);
  noStroke();
  textSize(15);
  textAlign(LEFT);

  // On first use of this method, allocate space for an array
  // to store the values for the left and right edges of the tabs
  if (tabLeft == null) {
    tabLeft = new float[columnCount];
    tabRight = new float[columnCount];
  }

  float runningX = plotX1; 
  tabTop = plotY1 - textAscent() - 15;
  tabBottom = plotY1;

  for (int col = 0; col < columnCount; col++) {
    String title = data.getColumnName(col);
    tabLeft[col] = runningX; 
    float titleWidth = textWidth(title);
    tabRight[col] = tabLeft[col] + tabPad + titleWidth + tabPad;

    // If the tab selected, set its background white, otherwise use pale gray
    fill(columnsSelected[col] ? 255 : 224);
    rect(tabLeft[col], tabTop, tabRight[col], tabBottom);

    // If the tab selected, use black for the text, otherwise use dark gray
    fill(columnsSelected[col] ? 0 : 64);
    text(title, runningX + tabPad, plotY1 - 10);

    runningX = tabRight[col];
  }
}

// Zoom in and out on location of pointer using mouse wheel
void mouseWheel(MouseEvent event) {
  swt-=event.getCount();
  if (swt==0) {
    zoom=1.0;
  } else if (swt>=1 && swt<=10) {
    zoom=pow(2, swt);
  } else if (swt<=-1 && swt>=-10) {
    zoom=1/pow(2, abs(swt));
  }
  xzt=((zoom-1)*width/2)/zoom;
  yzt=((zoom-1)*height/2)/zoom;
  if (event.getCount()<=-1) {
    xpt-=(mouseX-width/2)/zoom;
    ypt-=(mouseY-height/2)/zoom;
  } else {
    xpt+=(mouseX-width/2)/(pow(2, swt+1));
    ypt+=(mouseY-height/2)/(pow(2, swt+1));
  }
}

// Click on top tab to get to another data set
void mousePressed() {
  if (mouseY > tabTop && mouseY < tabBottom) {
    for (int col = 0; col < columnCount; col++) {
      if (mouseX > tabLeft[col] && mouseX < tabRight[col]) {
        SetCurrent(col);
      }
    }
  }
}


void SetCurrent(int col) {
  currentColumn = col;
  columnsSelected[col] = !columnsSelected[col];

  for (int row = 0; row < rowCount; row++) {
    interpolators[row].target(data.getFloat(row, col));
  }
}

// x and y-axis labels
void DrawAxisLabels() {
  fill(0);
  textSize(13);
  textLeading(15);

  textAlign(CENTER, CENTER);
  text("Number\nof deaths", labelX, (plotY1+plotY2)/2);
  textAlign(CENTER);
  text("Year", (plotX1+plotX2)/2, labelY);
}

// x-axis tick labels
void DrawYearLabels() {
  fill(0);
  textSize(10);
  textAlign(CENTER);

  // Use thin, gray lines to draw the grid
  stroke(224);
  strokeWeight(1);

  for (int row = 0; row < rowCount; row++) {
    if (years[row] % yearInterval == 0) {
      float x = map(years[row], yearMin, yearMax, plotX1, plotX2);
      text(years[row], x, plotY2 + textAscent() + 10);
      line(x, plotY1, x, plotY2);
    }
  }
}

// y axis tick labels
void DrawDeathLabels() {
  fill(0);
  textSize(10);
  textAlign(RIGHT);

  stroke(128);
  strokeWeight(1);

  for (float v = dataMin; v <= dataMax; v += deathIntervalMin) {
    if (v % deathIntervalMin == 0) {     // If a tick mark
      float y = map(v, dataMin, dataMax, plotY2, plotY1);  
      if (v % deathInterval == 0) {        // If a major tick mark
        float textOffset = textAscent()/2;  // Center vertically
        if (v == dataMin) {
          textOffset = 0;                   // Align by the bottom
        } else if (v == dataMax) {
          textOffset = textAscent();        // Align by the top
        }
        text(floor(v), plotX1 - 10, y + textOffset);
        line(plotX1 - 4, y, plotX1, y);     // Draw major tick
      } else {
        //line(plotX1 - 2, y, plotX1, y);   // Draw minor tick
      }
    }
  }
}

//draws line graph of data
void DrawDataLine(int col) {
  beginShape( );
  noFill();
  if (columnsSelected[col]) {
    stroke(columnsColors[col]);
  } else {
    stroke(columnsColors[col], 10);
  }
  strokeWeight(5);
  int rowCount = data.getRowCount( );
  for (int row = 0; row < rowCount; row++) {
    if (data.isValid(row, col)) {
      float value = data.getFloat(row, col);
      float x = map(years[row], yearMin, yearMax, plotX1, plotX2);
      float y = map(value, dataMin, dataMax, plotY2, plotY1);
      vertex(x, y);
    }
  }
  endShape( );
}

// shows data value when mouse hovers over line graph
void DrawDataHighlight(int col) {
  for (int row = 0; row < rowCount; row++) {
    if (data.isValid(row, col)) {
      float value = data.getFloat(row, col);
      float x = map(years[row], yearMin, yearMax, plotX1, plotX2);
      float y = map(value, dataMin, dataMax, plotY2, plotY1);
      if (dist(mouseX, mouseY, x, y) < 3) {
        strokeWeight(20);
        point(x, y);
        fill(0);
        textSize(25);
        textAlign(CENTER);
        text(nf(value, 0, 3) + " (" + years[row] + ")", x, y-10);
      }
    }
  }
}
