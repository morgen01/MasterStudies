# -*- coding: utf-8 -*-
# ******************************************************************** #
# SU19-CPSC-51100-002, Summer-2 2019                                   #
# NAME: Christina Morgenstern                                          #
# PROGRAMMING ASSIGNMENT #5 – Data Preparations and Statistics         #
# 8/17/2019                                                            #
# ******************************************************************** #

# Printing header statement
print('''CPSC-51100, Summer 2019
NAME: Christina Morgenstern
PROGRAMMING ASSIGNMENT #5''')
print()

# import packages
import pandas as pd
import re

# load data into dataframe and display top 10 rows
df = pd.read_csv('cps.csv')
#df.head(10)

# retrieve column names
#df.columns

# generate new dataframe on required information
df2 = df[['School_ID','Short_Name','Is_High_School','Zip','Student_Count_Total','College_Enrollment_Rate_School']]
#df2.head()

#df.dtypes

## 2g. Display lowest grade offered for each school

# function to extraxt the lowest grade which is listed first 
def getLowestGrade(row):
    grades = str(row['Grades_Offered_All']).split(",")[0].strip()
    return grades

df2['Lowest_Grade_Offered'] = df.apply(lambda row: getLowestGrade(row), axis=1)

## 2h. Display highest grade offered for each school

# function to extract the highest grade which is listed last 
def getHighestGrade(row):
    grades = str(row['Grades_Offered_All']).split(",")[::-1][0].strip()    
    return grades

df2['Highest_Grade_Offered'] = df.apply(lambda row: getHighestGrade(row), axis=1)

## 3a. Mean and standard deviation of College Enrollment Rate for High Schools

# fill missing values in College_Enrollment_Rate_School column with mean value of the column
df2['College_Enrollment_Rate_School'].fillna((df['College_Enrollment_Rate_School'].mean()), inplace=True)
#df2.head()

## 3a. Mean and standard deviation of College enrollment rate for High Schools
enrollment_mean = df2.loc[df2['Is_High_School'] == True, 'College_Enrollment_Rate_School'].mean()
enrollment_std = df2.loc[df2['Is_High_School'] == True, 'College_Enrollment_Rate_School'].std()

#print('College Enrollment Rate for High Schools = {:.2f} (sd={:.2f})'.format(enrollment_mean, enrollment_std))


## 3b. Mean and standard deviation of Student count total for non-High Schools
count_mean=df.loc[df['Is_High_School'] == False, 'Student_Count_Total'].mean()
count_std=df.loc[df['Is_High_School'] == False, 'Student_Count_Total'].std()

#print('Total Student Count for non-High Schools = {:.2f} (st={:.2f})'.format(count_mean,count_std))

## 3c. Distribution of starting hours for all school

#df['School_Hours'].head()

# function to retrieve starting hour without the 0 in front
def get_starthour(row):
    raw = str(row['School_Hours'])
    if raw == 'nan':
        return raw
    else:   
        time_text = re.search('[0-9]:[0-9][0-9]', raw)  #Finds strings like "H:MM"
        if time_text:
            hour = time_text.group(0)[0] #Get the first letter of the first matching expression   
            return hour
        else:
            loose_text = re.search('[0-9] *[aA] *[mM] *-', raw)
            hour = loose_text.group(0)[0] #Get the first letter of the first matching expression   
            return hour

df2['School_Start_Hour'] = df.apply(lambda row: get_starthour(row), axis=1)

# print output
print(df2.head())
print()
print('College Enrollment Rate for High Schools = {:.2f} (sd={:.2f})'.format(enrollment_mean, enrollment_std))
print()
print('Total Student Count for non-High Schools = {:.2f} (st={:.2f})'.format(count_mean,count_std))
print()

# print the count of each starting hour
print('Distribution of Starting Hours')
count = df2.groupby('School_Start_Hour').size().sort_values(ascending=False)

for key, value in count.iteritems():
    if key != 'nan':    
        print(key+'am:', value)

## 3d. Number of schools outside the loop Neighborhood

schools_loop_zip = df2['Zip'].isin((60601,60602,60603,60604,60605,60606,60607,60616))

non_loop_schools = df2.loc[~schools_loop_zip]
num_nonloop = len(non_loop_schools)
print('\nNumber of schools outside the Loop: {} \n'.format(num_nonloop))



