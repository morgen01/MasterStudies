# PROGRAMMING ASSIGNMENT #1
# CPSC-51100 Summer 2019
# Christina Morgenstern
# Online descriptive statistics

# This program computes the sample mean and the sample variance using an online approach

# Printing header statement
print('''CPSC-51100, Summer 2019
NAME: Christina Morgenstern
PROGRAMMING ASSIGNMENT #1''')

# initialize variables
mean = 0
var = 0
n = 0

# prompt user for input 
num = int(input('Enter a number: '))

while num>=0:
    
    # update sample mean
    prev_mean = mean
    n = n+1
    mean = prev_mean +((num-prev_mean)/n)
    
    # update sample variance
    if n>1:
        prev_var = var
        var = (((n-2)/(n-1))*prev_var)+(((num-prev_mean)**2)/(n))
    else:
        var=0
    
    print('Mean is',float(mean),'\tVariance is',float(var))
    num = int(input('Enter a number: '))
    

