import matplotlib.pyplot as plt
import matplotlib.lines as lines

formados = [1, 4, 5, 3, 4, 2, 3, 3, 4]
renda_familiar = [11, 12, 12, 9, 8, 6, 6, 4.5, 2]

# fig, ax = plt.subplots()

# line = lines.Line2D([2, 5], [3.5, 12.5],
#                     lw=2, color='red', axes=ax)
# ax.add_line(line)

plt.scatter(formados, renda_familiar)
plt.show()

