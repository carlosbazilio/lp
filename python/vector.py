class Vector(object):
    def __init__(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z

    @classmethod
    def from_sequence(cls, sequence):
        return cls(*sequence)

    @classmethod
    def from_vector(cls, vec):
        return cls(vec.x, vec.y, vec.z)

    def __repr__(self):
        return "Vector(%s, %s, %s)" % (self.x, self.y, self.z)

if __name__ == '__main__':
    print (Vector(1,2,3))
    print (Vector.from_sequence([4,5,6]))
    print (Vector.from_sequence((7,8,9)))
    v = (Vector(10, 11, 12))
    print (Vector.from_vector(v))

