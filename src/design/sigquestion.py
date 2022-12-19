import csv

class Movies:
    def __init__(self, listOfMovies) -> None:
        self.movies = {}
        for movie in listOfMovies:
            year = movie[7]
            if year not in self.movies:
                self.movies[year] = {}
            genres = [genre.strip() for genre in movie[1].split('|')]
            for genre in genres:
                if genre not in self.movies[year]:
                    self.movies[year][genre] = []
            self.movies[year][genre].append(movie)
    def searchBy(self, startBy, endBy, genre):
        queries = []
        for year in range(int(startBy),int(endBy)+1): 
            year = str(year)
            if year in self.movies and genre in self.movies[year]:
                query = self.movies[year][genre]
                queries += query
        return queries
    
class CSVReader:
    def __init__(self, csvPath=None) -> None:
        self.rows = []
        if csvPath:
            self.readCSV(csvPath)
    def readCSV(self, csvPath):
        try:
            with open(csvPath, 'r') as csvfile:
                csvreader = csv.reader(csvfile, delimiter=',')                
                fields = next(csvreader)            
                for row in csvreader:
                    self.rows.append(row)
            print('Field names are:' + ', '.join(field for field in fields))            
        except Exception as e:
            print('An exception occurred: ', e)
        return self.rows
    def getRows(self):
        return self.rows
        
listOfMovies = CSVReader('src/design/movies.csv').getRows()
# print(listOfMovies)
movies = Movies(listOfMovies)
search = movies.searchBy('2007','2009','Thriller')
print(search)


# # Python program to illustrate
# # enumerate function
# l1 = ["eat", "sleep", "repeat"]
# s1 = "geek"
  
# # creating enumerate objects
# obj1 = enumerate(l1)
# obj2 = enumerate(s1)
  
# print ("Return type:", type(obj1))
# print (list(enumerate(l1)))
  
# # changing start index to 2 from 0
# print (list(enumerate(s1, 2)))

# # Python program showing how to
# # multiple input using split

# # taking two inputs at a time
# x, y = input("Enter two values: ").split()
# print("Number of boys: ", x)
# print("Number of girls: ", y)
# print()

# # taking three inputs at a time
# x, y, z = input("Enter three values: ").split()
# print("Total number of students: ", x)
# print("Number of boys is : ", y)
# print("Number of girls is : ", z)
# print()

# # taking two inputs at a time
# a, b = input("Enter two values: ").split()
# print("First number is {} and second number is {}".format(a, b))
# print()

# # taking multiple inputs at a time
# # and type casting using list() function
# x = list(map(int, input("Enter multiple values: ").split()))
# print("List of students: ", x)

# # A function that returns the 'year' value:
# def myFunc(e):
#   return e['year']

# cars = [
#   {'car': 'Ford', 'year': 2005},
#   {'car': 'Mitsubishi', 'year': 2000},
#   {'car': 'BMW', 'year': 2019},
#   {'car': 'VW', 'year': 2011}
# ]

# cars.sort(key=myFunc)
# # A function that returns the length of the value:
# def myFunc(e):
#   return len(e)

# cars = ['Ford', 'Mitsubishi', 'BMW', 'VW']

# cars.sort(key=myFunc)

        