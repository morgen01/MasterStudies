# -*- coding: utf-8 -*-
# ******************************************************************** #
# SU19-CPSC-51100-002, Summer-2 2019                                   #
# NAME: Group 2: Christina Morgenstern, Seth Gory, Amy Noyes           #
# PROGRAMMING ASSIGNMENT #2 – k-Means Clustering                       #
# 7/25/2019                                                            #
# ******************************************************************** #

# This program implements the k-Means Algorithm to find clusters in numerical data

# Printing header statement
print('''CPSC-51100, Summer 2019
NAME: Christina Morgenstern, Seth Gory, Amy Noyes,
PROGRAMMING ASSIGNMENT #2''')

# Specify new functions
#def assign_to_clusters (data, clusters, centroids, point_assignments):
 #   """Function to place each point in closest cluster"""
  #  for i,value in enumerate(data):
   #     if 
    #    clusters.append()
     #   point_assignments[j]=closest_index
        

#def update_centroid_location (data, clusters, centroids):
 #   """Function to update corresponding centroid value"""
   

#for i in point_assignments[j]:
 #   print("Point", j, "in cluster",cluster)
         

# prompt user for number of clusters
k = int(input('Enter the number of clusters: '))

# read data from file, strip lines of ending char and convert to floats
input_file = 'prog2-input-data.txt'
data = [float(x.rstrip()) for x in open(input_file)]

# create output file for writing
output_file = 'prog2-output-data.txt'
fo = open(output_file, 'w')

# create and initialize variables
centroids = dict(zip(range(k), data[0:k])
#clusters = dict(zip(range(k), [[] for i in range(k)]))

#points_to_clusters = dict(zip(data, clusters)

#old_point_assignment = {}

#i=0
#while i < 100:
# old_point_assignment = dict(current_point_assignment)