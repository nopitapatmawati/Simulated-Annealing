import random, math

def x1x2(): #to generate x1 and x2
    x1 = random.uniform(-10, 10)
    x2 = random.uniform(-10, 10)
    return x1,x2

def fitnest(x1,x2): #to calculation the fitness
    f = (4-2.1*math.pow(x1,2)+(math.pow(x1,4)/3))*math.pow(x1,2)+(x1*x2)+(-4+(4*math.pow(x2,2)))*math.pow(x2,2)
    return f

currentstate = x1x2()
Bestsofar = currentstate
T=10**5
Tmin = 10**-100
deltaE=0

while T>Tmin: #the looping to find the best state to get the minimum fitness
    newstate=x1x2()
    deltaE =fitnest(newstate[0], newstate[1])-fitnest(currentstate[0], currentstate[1])
    if deltaE<0: #to compare the newstate and currentstate which one had the lowest fitness. the lowest fitness become the best so far
        currentstate=newstate
        Bestsofar=currentstate
    else: #this is for not getting trapped at local minimum so we use the probability
        omega = random.uniform(0,1)
        prob = math.exp(-deltaE/T)
        if omega<prob:
            currentstate=newstate
    #slowly make the temperature down
    coolingrate = random.uniform(0.999, 0.9999)
    T=T*coolingrate

print("Best so far: x1= %.4f" % Bestsofar[0],", x2= %.4f" % Bestsofar[1],", minimum result= %.4f" % fitnest(Bestsofar[0],Bestsofar[1]))



