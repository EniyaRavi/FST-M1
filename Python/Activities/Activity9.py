numList1 = [10, 45, 20, 11, 66]

numList2 = [24, 67, 89, 45, 22]

print("First List ", numList1)
print("Second List ", numList2)

thirdList = []

for num in numList1:
    if (num % 2 != 0):
        thirdList.append(num)

for num in numList2:
    if (num % 2 == 0):
        thirdList.append(num)

print("result List is:")
print(thirdList)