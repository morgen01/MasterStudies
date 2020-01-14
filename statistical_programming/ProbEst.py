# -*- coding: utf-8 -*-

# ******************************************************************** #
# SU19-CPSC-51100-002, Summer-2 2019                                   #
# NAME: Christina Morgenstern                                          #
# PROGRAMMING ASSIGNMENT #4 – Estimating Probabilities                 #
# 8/07/2019                                                            #
# ******************************************************************** #

# Printing header statement
print('''CPSC-51100, Summer 2019
NAME: Christina Morgenstern
PROGRAMMING ASSIGNMENT #4''')
print()

# import packages
from pandas import Series, DataFrame
import pandas as pd

# open csv file as dataframe and display top entries
df = pd.read_csv('cars.csv')
#df.head()

total_rows = len(df)
#total_rows

df.columns

# create a new dataframe using only the two columns needed
cars_df = DataFrame(df, columns = ['make','aspiration'])
#cars_df.head()

# reorganization of data
cars = pd.crosstab(index=df['aspiration'], columns=df['make'])
#cars

# total number of features
total_features = cars.sum()
#total_features

# broadcasting for calculation of probabilities
con_prob = (cars/total_features)*100
con_prob

# print conditional probabilities 
for index,value in con_prob.iteritems():
    print(index,value)
    print()


# probability of each make
make_probability = df['make'].value_counts()/df['make'].count()*100
# make_probability

# printing of make probabilities
for index,value in make_probability.sort_index().items(): 
    print("Prob(make={}) = {:.2f}%".format(index, value))






