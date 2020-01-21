class HashElement(object):
	def __init__(self, key, value):
		self.key = key
		self.value = value

	def getKey(self):
		return self.key

	def getValue(self):
		return self.value




class HashMap(object):
	def __init__(self, size = 100):
		self.size = size
		self.map = [None]*size

	def put(self, key, value):
		indicator = key % self.size
		while self.map[indicator] and self.map[indicator].getKey() != key:
			indicator = (7 * indicator + 1) % self.size
		self.map[indicator] = HashElement(key, value)

		return indicator

	def get(self, key):
		indicator = key % self.size
		while self.map[indicator] and self.map[indicator].getKey() != key:
			indicator = (7 * indicator + 1) % self.size

		return self.map[indicator].getValue()

	def linearPut(self, key, value):
		indicator = key % self.size
		linear_progress = 1
		while self.map[indicator] and self.map[indicator].getKey() != key:
			indicator = (key + linear_progress) % self.size
			linear_progress += 1
		self.map[indicator] = HashElement(key, value)

		return indicator

	def linearGet(self, key):
		indicator = key % self.size
		linear_progress = 1
		while self.map[indicator] and self.map[indicator].getKey() != key:
			indicator = (key + linear_progress) % self.size
			linear_progress += 1

		return self.map[indicator].getValue()

	def quadraticPut(self, key, value):
		indicator = key % self.size
		timesProbed = 0
		while self.map[indicator] and self.map[indicator].getKey() != key:
			timesProbed += 1
			indicator = (key + (2 * timesProbed) - 1) % self.size
		self.map[indicator] = HashElement(key, value)

	def quadraticGet(self, key):
		indicator = key % self.size
		timesProbed = 0
		while self.map[indicator] and self.map[indicator].getKey() != key:
			timesProbed += 1
			indicator = (key + (2 * timesProbed) - 1) % self.size
			
		return self.map[indicator].getValue()


def main():
    print ('send help')



main()
