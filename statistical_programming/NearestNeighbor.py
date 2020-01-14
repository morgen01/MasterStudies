# -*- coding: utf-8 -*-
# ******************************************************************** #
# SU19-CPSC-51100-002, Summer-2 2019                                   #
# NAME: Christina Morgenstern                                          #
# PROGRAMMING ASSIGNMENT #3 – NearestNeighbor                          #
# 7/31/2019                                                            #
# ******************************************************************** #

# Printing header statement
print('''CPSC-51100, Summer 2019
NAME: Christina Morgenstern
PROGRAMMING ASSIGNMENT #3 \n''')

# import Numpy library
import numpy as np

# load train data and store features as an array of floating point values
train_data = np.loadtxt('iris-training-data.csv', dtype = 'float64', delimiter=',', usecols=[0,1,2,3])

# load train data and store class labels as string array
train_label = np.loadtxt('iris-training-data.csv', dtype = 'string_', delimiter=',', usecols=[4])

# load test data and store features as an array of floating point values
test_data = np.loadtxt('iris-testing-data.csv', dtype = 'float64', delimiter=',', usecols=[0,1,2,3])

# load test data and store class labels as string array
test_label = np.loadtxt('iris-testing-data.csv', dtype = 'string_', delimiter=',', usecols=[4])


def pairwise_distances (train_data, test_data):
    """  Computes pairwise Euclidian distances between test and training values using vectorization. """
    
    return np.sqrt(np.sum((train_data[:, np.newaxis] - test_data[np.newaxis])**2, axis=2))

# apply pairwise_distance functions to get distances
nearest_neighbor = pairwise_distances (train_data, test_data)

# get indices of closest neighbors
get_indices = np.argmin(nearest_neighbor, axis=1)

# get labels of predicted instances
predicted_labels = train_label[get_indices]

# generate ID array
id = np.arange(1,76)

# stuck arrays for ID, true and predicted class labels on top
output = np.stack((id,test_label,predicted_labels), axis=-1)

# output true and predicted class labels
print('#, \t True, \t\t Predicted, \n', output)

# Compute accuracy
accuracy = np.sum(predicted_labels == test_label)/len(predicted_labels)*100
print('Accuracy:' ,"%.2f" % accuracy + "%")

