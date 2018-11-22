# Copyright 2018 Xanadu Quantum Technologies Inc.

# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at

#     http://www.apache.org/licenses/LICENSE-2.0

# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# ===========================================
# Blackbird quantum assembly language example
# ===========================================
# Blackbird is case sensitive.
# Newlines at the same indentation level indicate
# the end of a statement.
# Like Python, we use # for comments.

# Variable are defined at the top of the file. 

# Format for defining variables:
#   type name = expression
#
# Allowed literals:
#   int: 0, 1, 5
#   float: 0.43, -0.123, 89.23e-10
#   complex: 5j, 8-1j, 0.54+0.21j
#   bool: True, False
#   str: any ASCII string surrounded by quotes, "sdfds"
int n = 5
float alpha = 0.5432
complex beta = 0.43e-4-0.912j
bool flag = True
str name = "program1"

# Blackbird allows expressions using the operators:
#   +, -, *, /, ** (exponentiation)
# and the intrinsic functions:
#   exp(), sin(), cos(), sqrt()
# You can also use PI and previous variable names in your
# expressions.
float gamma = 2*cos(alpha*pi)

# we can also define arrays, by specifying 'array' after
# the variable type.

# Can optionally specify the shape of the array using square
# brackets directly after the variable name (i.e. U4[4, 4]))
# but this is optional.

complex array U4[4, 4] =
	2.00+1.81j  1.39+0.15j  1.56+0.54j  0.88+0.65j
	1.39+0.15j  0.69+0.91j  1.31+0.21j  0.87+0.58j
	1.56+0.54j  1.31+0.21j  1.09+0.14j  0.58+1.74j
	0.88+0.65j  0.87+0.58j  0.58+1.74j  1.52+0.59j

# begin program execution
# 'with' statement indicates
with GBS:
    # set the initial state
	Coherent(alpha**2, sqrt(pi)) | 2

    # set the Interferometer here
	Interferometer(U4) | [0, 1, 2, 3]