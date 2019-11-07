Dataset: 'generator.ipynb'

We considered the viability of importing real data to populate our backend database, but there are a few issues with this option. First, all current records of Black Belt USA (BBUSA) exist in physical form in the San Diego studio, so using real data requires scanning relevant physical documents and manually entry. Second, by nature of the data being client-centric, our real dataset includes personal information such as legal names, contact information, familial ties, etc. For these reasons, in order to avoid time-consuming, error-prone manual labor and to protect user privacy, we decided to generate a random dataset based on observations of a set of real records from BBUSA. 

I generated our dataset with a combination of random name, email, and password generators online and Python data frames with pandas and Jupyter Notebook. First, I populated the Students, Instructors, Users, and Classes tables as comma-delineated CSV files. Next, using these data as basis, I coded Python scripts to generate the Takes (Student takes Classes) and Attendance (Student attends Classes) tables. There are a few concerns that complicated this process. For example, the classes that students take are determined by the student’s age and the class’s age range. The Takes.start_date field is a function depending on on the student’s current age minus the Classes.start_age field. Different classes fall on different days of the week, so Attendance.date needs to take into consideration the day of the class that said student is enrolled in, etc. In order to generate a random, diverse, realistic, and dependable dataset, all this logic is written into our Python scripts. 

The next step in further developing this dataset would mean developing the Parents table (based on last names and students’ age; for example, a 24-year-old student does not need a corresponding parent) and its relations to other parts of the database. 

Database Loading:
The entire dataset and the Python script are in our git repo. 

All of our data loading code is in the "Data Loading.ipynb". After generating our own datasets, we leveraged python pandas for loading and parsing the csv and the mysql api to connect and load data to our database. After setting up a connection with our database, we went through the process of reading the csv, some slight data cleaning, and then finally looping over the dataframe and inserting the values to the correct table. 

Here below is an example of our workflow: 
1. classes = pd.read_csv('Classes.csv')
2. classes.head()

CID	| start_age	| end_age	|start_time	|end_time	|day
1.0	|3.0	    |5.0	    |8am	    |10am	    |Sunday
2.0	|6.0	    |11.0	    |10am	    |12pm	    |Saturday

3. Turn dataframe into lists of list since mysql has a executemany that operates on lists of list
[[1.0, '8am', '10am', 3.0, 5.0, None],
 [2.0, '10am', '12pm', 6.0, 11.0, None],
 [3.0, '3pm', '5pm', 6.0, 11.0, None]...]

4. Code to insert into Classes table
query = "INSERT INTO innodb.Classes (CID, start_time, end_time, target_start_age, target_older_age, description) 
		VALUES (%s, %s,%s,%s, %s,%s)"
cursor.executemany(query, classesList)
db.commit()
print(cursor.rowcount, "records inserted")
