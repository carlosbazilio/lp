#Using the Force formula F=ma

while True:
  mass = int(input("Enter the mass value: "))
  if mass > 0:
    break
while True:
  acceleration = int(input("Enter the acceleration: "))
  if acceleration > 0:
    break
print("The Force is", mass * acceleration)

