-- Sets initial database due to using different file for queries
USE library;

-- Assignment C

-- 1. Display all contents of the Clients table
SELECT *
FROM Client;

-- Results
/*1	Kaiden	Hill	2006	Student
2	Alina	Morton	2010	Student
3	Fania	Brooks	1983	Food Scientist
4	Courtney	Jensen	2006	Student
5	Brittany	Hill	1983	Firefighter
6	Max	Rogers	2005	Student
7	Margaret	McCarthy	1981	School Psychologist
8	Julie	McCarthy	1973	Professor
9	Ken	McCarthy	1974	Securities Clerk
10	Britany	O'Quinn	1984	Violinist
11	Conner	Gardner	1998	Licensed Massage Therapist
12	Mya	Austin	1960	Parquet Floor Layer
13	Thierry	Rogers	2004	Student
14	Eloise	Rogers	1984	Computer Security Manager
15	Gerard	Jackson	1979	Oil Exploration Engineer
16	Randy	Day	1986	Aircraft Electrician
17	Jodie	Page	1990	Manufacturing Director
18	Coral	Rice	1996	Window Washer
19	Ayman	Austin	2002	Student
20	Jaxson	Austin	1999	Repair Worker
21	Joel	Austin	1973	Police Officer
22	Alina	Austin	2010	Student
23	Elin	Austin	1962	Payroll Clerk
24	Ophelia	Wolf	2004	Student
25	Eliot	McGuire	1967	Dentist
26	Peter	McKinney	1968	Professor
27	Annabella	Henry	1974	Nurse
28	Anastasia	Baker	2001	Student
29	Tyler	Baker	1984	Police Officer
30	Lilian	Ross	1983	Insurance Agent
31	Thierry	Arnold	1975	Bus Driver
32	Angelina	Rowe	1979	Firefighter
33	Marcia	Rowe	1974	Health Educator
34	Martin	Rowe	1976	Ship Engineer
35	Adeline	Rowe	2005	Student
36	Colette	Rowe	1963	Professor
37	Diane	Clark	1975	Payroll Clerk
38	Caroline	Clark	1960	Dentist
39	Dalton	Clayton	1982	Police Officer
40	Steve	Clayton	1990	Bus Driver
41	Melanie	Clayton	1987	Computer Engineer
42	Alana	Wilson	2007	Student
43	Carson	Byrne	1995	Food Scientist
44	Conrad	Byrne	2007	Student
45	Ryan	Porter	2008	Student
46	Elin	Porter	1978	Computer Programmer
47	Tyler	Harvey	2007	Student
48	Arya	Harvey	2008	Student
49	Serena	Harvey	1978	School Teacher
50	Lilly	Franklin	1976	Doctor
51	Mai	Franklin	1994	Dentist
52	John	Franklin	1999	Firefighter
53	Judy	Franklin	1995	Firefighter
54	Katy	Lloyd	1992	School Teacher
55	Tamara	Allen	1963	Ship Engineer
56	Maxim	Lyons	1985	Police Officer
57	Allan	Lyons	1983	Computer Engineer
58	Marc	Harris	1980	School Teacher
59	Elin	Young	2009	Student
60	Diana	Young	2008	Student
61	Diane	Young	2006	Student
62	Alana	Bird	2003	Student
63	Anna	Becker	1979	Security Agent
64	Katie	Grant	1977	Manager
65	Joan	Grant	2010	Student
66	Bryan	Bell	2001	Student
67	Belle	Miller	1970	Professor
68	Peggy	Stevens	1990	Bus Driver
69	Steve	Williamson	1975	HR Clerk
70	Tyler	Williamson	1999	Doctor
71	Izabelle	Williamson	1990	Systems Analyst
72	Annabel	Williamson	1960	Cashier
73	Mohamed	Waters	1966	Insurance Agent
74	Marion	Newman	1970	Computer Programmer
75	Ada	Williams	1986	Computer Programmer
76	Sean	Scott	1983	Bus Driver
77	Farrah	Scott	1974	Ship Engineer
78	Christine	Lambert	1973	School Teacher
79	Alysha	Lambert	2007	Student
80	Maia	Grant	1984	School Teacher
*/

-- 2. First names, last names, ages and occupations of all clients
SELECT ClientFirstName, ClientLastName, year(curdate()) - ClientDOB AS age, Occupation
FROM Client;

-- Results
/*Kaiden	Hill	18	Student
Alina	Morton	14	Student
Fania	Brooks	41	Food Scientist
Courtney	Jensen	18	Student
Brittany	Hill	41	Firefighter
Max	Rogers	19	Student
Margaret	McCarthy	43	School Psychologist
Julie	McCarthy	51	Professor
Ken	McCarthy	50	Securities Clerk
Britany	O'Quinn	40	Violinist
Conner	Gardner	26	Licensed Massage Therapist
Mya	Austin	64	Parquet Floor Layer
Thierry	Rogers	20	Student
Eloise	Rogers	40	Computer Security Manager
Gerard	Jackson	45	Oil Exploration Engineer
Randy	Day	38	Aircraft Electrician
Jodie	Page	34	Manufacturing Director
Coral	Rice	28	Window Washer
Ayman	Austin	22	Student
Jaxson	Austin	25	Repair Worker
Joel	Austin	51	Police Officer
Alina	Austin	14	Student
Elin	Austin	62	Payroll Clerk
Ophelia	Wolf	20	Student
Eliot	McGuire	57	Dentist
Peter	McKinney	56	Professor
Annabella	Henry	50	Nurse
Anastasia	Baker	23	Student
Tyler	Baker	40	Police Officer
Lilian	Ross	41	Insurance Agent
Thierry	Arnold	49	Bus Driver
Angelina	Rowe	45	Firefighter
Marcia	Rowe	50	Health Educator
Martin	Rowe	48	Ship Engineer
Adeline	Rowe	19	Student
Colette	Rowe	61	Professor
Diane	Clark	49	Payroll Clerk
Caroline	Clark	64	Dentist
Dalton	Clayton	42	Police Officer
Steve	Clayton	34	Bus Driver
Melanie	Clayton	37	Computer Engineer
Alana	Wilson	17	Student
Carson	Byrne	29	Food Scientist
Conrad	Byrne	17	Student
Ryan	Porter	16	Student
Elin	Porter	46	Computer Programmer
Tyler	Harvey	17	Student
Arya	Harvey	16	Student
Serena	Harvey	46	School Teacher
Lilly	Franklin	48	Doctor
Mai	Franklin	30	Dentist
John	Franklin	25	Firefighter
Judy	Franklin	29	Firefighter
Katy	Lloyd	32	School Teacher
Tamara	Allen	61	Ship Engineer
Maxim	Lyons	39	Police Officer
Allan	Lyons	41	Computer Engineer
Marc	Harris	44	School Teacher
Elin	Young	15	Student
Diana	Young	16	Student
Diane	Young	18	Student
Alana	Bird	21	Student
Anna	Becker	45	Security Agent
Katie	Grant	47	Manager
Joan	Grant	14	Student
Bryan	Bell	23	Student
Belle	Miller	54	Professor
Peggy	Stevens	34	Bus Driver
Steve	Williamson	49	HR Clerk
Tyler	Williamson	25	Doctor
Izabelle	Williamson	34	Systems Analyst
Annabel	Williamson	64	Cashier
Mohamed	Waters	58	Insurance Agent
Marion	Newman	54	Computer Programmer
Ada	Williams	38	Computer Programmer
Sean	Scott	41	Bus Driver
Farrah	Scott	50	Ship Engineer
Christine	Lambert	51	School Teacher
Alysha	Lambert	17	Student
Maia	Grant	40	School Teacher
*/

-- 3. First and last names of clients that borrowed books in March 2018
SELECT c.ClientFirstName, c.ClientLastName, b.BorrowDate
FROM Client as c
-- Joins the borrower table to have both tables visible
INNER JOIN Borrower as b
ON c.clientid = b.clientid
-- Makes sure borrowdate will be in March 2018
WHERE b.BorrowDate between '2018-03-01' AND '2018-03-30';

-- Results
/*Maia	Grant	2018-03-18
Marcia	Rowe	2018-03-18
Alysha	Lambert	2018-03-07
Tyler	Baker	2018-03-11
Katy	Lloyd	2018-03-14
Angelina	Rowe	2018-03-10
Gerard	Jackson	2018-03-02
Carson	Byrne	2018-03-15
*/

-- 4. First and last names of the top 5 authors clients borrowed in 2017
-- Combines first and last name for easier reading
SELECT Concat(a.AuthorFirstName, ' ', a.AuthorLastName) as Name, Count(Borrower.BookID) as "Borrows"
FROM Author as a
-- Joins book
INNER JOIN Book
ON a.authorid = book.authorid
-- Needed borrower data for borrow count so had to reference borrower also
INNER JOIN Borrower
ON Borrower.bookid = book.bookid
-- Checks to make sure borrowdate is in 2017
WHERE BorrowDate between '2017-01-01' and '2017-12-31'
-- Will sum per name
GROUP BY Name
ORDER BY Count(Borrower.BookID) DESC
-- Outputs top 5 results
LIMIT 5;

-- Results 
/*Sofia Smith	7
Elena Martin	7
Logan Moore	7
Maria Brown	6
Zoe Roy	5
*/

-- 5.Nationalities of the least 5 authors that clients borrowed during the years 2015-2017
SELECT DISTINCT a.AuthorNationality, Count(Borrower.BookID) as "Borrows"
FROM Author as a
-- Joins book
INNER JOIN Book
ON a.authorid = book.authorid
-- Joins borrower like above
INNER JOIN Borrower
ON Borrower.bookid = book.bookid
-- Makes sure borrow date happened between 2015 and 2017
WHERE BorrowDate between '2015-01-01' and '2017-12-31'
-- Will sum by nationality
GROUP BY a.AuthorID
-- outputs starting from lowest
ORDER BY Count(Borrower.BookID) ASC
LIMIT 5;

-- Results
/* Spain	3
Canada	5
USA	5
Great Britain	6
USA	6
*/

-- 6. The book that was most borrowed during the years 2015-2017
SELECT book.BookTitle, Count(Borrower.BookID) as "Borrows"
From Book
-- Joins Borrower
INNER JOIN Borrower
ON Borrower.bookid = book.bookid
-- Verifies borrowdate is somewhere between 2015 and 2017
WHERE BorrowDate between '2015-01-01' and '2017-12-31'
-- Will sum by booktitle
GROUP BY book.BookTitle
-- outputs starting at highest
ORDER BY Count(Borrower.BookID) DESC
-- only one being shown
LIMIT 1;

-- Results
/*The perfect match	13*/

-- 7. Top borrowed genres for client born in years 1970-1980
SELECT DISTINCT book.Genre, Count(Borrower.BookID) as "Borrows"
From Book
-- Joins Borrower
INNER JOIN Borrower
ON Borrower.bookid = book.bookid
-- Joins Client
INNER JOIN Client
ON Borrower.ClientID = Client.ClientID
-- Makes sure client was born between 1970 and 1980
WHERE ClientDOB between '1970-01-01' and '1980-12-31'
-- SUms by genre
GROUP BY book.Genre
-- outputs starting at highest
ORDER BY Count(Borrower.BookID) DESC
-- outputs top 10 since the prompt is non-specific
LIMIT 10;

-- Results
/*Science	24
Fiction	16
Well being	15
Humor	5
Society	4
History	3
Law	3
Children	3
Literature	3
*/

-- 8. Top 5 occupations that borrowed the most in 2016
SELECT DISTINCT Client.occupation, Count(Borrower.BookID) as "Borrows"
From Book
-- Joins Borrower
INNER JOIN Borrower
ON Borrower.bookid = book.bookid
-- Joins Client
INNER JOIN Client
ON Borrower.ClientID = Client.ClientID
-- Makes sure that only borrows in 2016 are being reviewed
WHERE BorrowDate between '2016-01-01' and '2016-12-31'
-- Being summed by occupation
GROUP BY Client.occupation
-- Highest values being outputted first
ORDER BY Count(Borrower.BookID) DESC
-- Top 5 being shown
LIMIT 5;

-- Results
/*Student	32
Bus Driver	8
Dentist	6
Computer Programmer	6
Police Officer	5*/

-- 9. Average Number of borrowed books by job title
-- Calculates average of Borrows
SELECT DISTINCT Client.occupation, Count(*)/COUNT(DISTINCT Client.ClientID) as "Borrows"
From Book
-- Borrower being joines
INNER JOIN Borrower
ON Borrower.bookid = book.bookid
-- Client being joines
INNER JOIN Client
ON Borrower.ClientID = Client.ClientID
-- Occupation will be summed
GROUP BY Client.occupation
-- Top values being shown first
ORDER BY Borrows DESC;

-- Results
/*Nurse	7.0000
Computer Security Manager	6.0000
Computer Programmer	5.6667
Dentist	5.6667
Cashier	5.0000
Food Scientist	5.0000
Manufacturing Director	5.0000
Oil Exploration Engineer	5.0000
Police Officer	4.5000
Student	4.4211
Bus Driver	4.0000
Doctor	4.0000
HR Clerk	4.0000
Insurance Agent	4.0000
Ship Engineer	4.0000
Systems Analyst	4.0000
Violinist	4.0000
School Teacher	3.6000
Professor	3.5000
Firefighter	3.2500
Computer Engineer	3.0000
Manager	3.0000
Payroll Clerk	3.0000
Repair Worker	3.0000
Aircraft Electrician	2.0000
Health Educator	2.0000
Licensed Massage Therapist	2.0000
Parquet Floor Layer	2.0000
School Psychologist	2.0000
Securities Clerk	2.0000
Security Agent	2.0000
Window Washer	2.0000*/

-- 10. Create a VIEW and display the titles that were borrowed by at least 20% of clients
-- CREATE VIEW  top20PercentTitles AS
-- SELECT Book.BookTitle, Count(Borrower.BookID) as "Borrows"
-- FROM Borrower
-- INNER JOIN Book
-- ON Borrower.BookID = Book.BookID
-- GROUP BY BookTitle
-- HAVING Count(Borrower.ClientID) >= Count(ALL Borrower.ClientID) * 0.2 
-- ORDER BY Borrows DESC
-- ;

SELECT * from top20PercentTitles;

-- Results
/*Electrical transformers	18
The perfect match	14
Programming using Python	14
Green nature	13
Digital Logic	12
History of theater	12
Performance evaluation	12
Positive figures	12
The red wall	11
Right and left	11
Computer networks	11
Industrial revolution	11
Build your database system	10
A gray park	10
How to be rich in one year	10
Computer security	10
How to be a great lawyer	9
Daily exercise	9
The chocolate love	9
Director and leader	9
Perfect rugby	9
Build your big data system	8
The silver uniform	8
Pollution today	7
Their bright fate	6
Black lines	6
The end	6
Participate	6
Perfect football	5
Play football every week	5
Maya the bee	4
Manage successful negotiations	3*/

-- 11. The top month of borrows in 2017
SELECT Month(BorrowDate), Count(Borrower.BookID) as "Borrows"
From Borrower
-- Borrows in 2017
WHERE BorrowDate between '2017-01-01' and '2017-12-31'
-- Grouping by the month
GROUP BY Month(BorrowDate)
-- Top values
ORDER BY Borrows DESC
-- Outputs 1
Limit 1;

-- Results 
/*8	10*/

-- 12. Average number of borrows by age
-- Calculates that age
SELECT Year(curdate()) - Client.ClientDOB as AGE, Count(DISTINCT Borrower.BookID)/COUNT(DISTINCT Client.ClientID) as "Borrows"
From Book
-- Joins Borrower
INNER JOIN Borrower
ON Borrower.bookid = book.bookid
-- Joins client
INNER JOIN Client
ON Borrower.ClientID = Client.ClientID
-- Sums by age
GROUP BY AGE
-- outputs top values first
ORDER BY Borrows DESC;

-- Results
/*30	9.0000
18	5.5000
21	5.0000
16	4.6667
19	4.5000
23	4.5000
46	4.5000
40	4.2500
45	4.0000
54	4.0000
29	4.0000
39	4.0000
56	4.0000
61	4.0000
17	3.7500
48	3.5000
25	3.3333
34	3.2500
38	3.0000
64	3.0000
41	3.0000
42	3.0000
47	3.0000
51	3.0000
20	3.0000
57	3.0000
32	3.0000
62	3.0000
49	2.6667
50	2.5000
22	2.0000
37	2.0000
28	2.0000
43	2.0000
26	2.0000
14	1.6667
44	1.0000
58	1.0000
*/


-- 13. The oldest and the youngest clients of the library
-- This was prompt was vague but this will output the Youngest age and then the oldest age
SELECT Concat(ClientFirstName, ' ', ClientLastName) as Name, ClientDOB
From Client
WHERE ClientDOB = (SELECT Min(ClientDOB) FROM Client) OR ClientDOB = (Select Max(ClientDOB) FROM Client)
GROUP BY Name, ClientDOB
ORDER BY ClientDOB
;

-- Results
/*Mya Austin	1960
Caroline Clark	1960
Annabel Williamson	1960
Alina Morton	2010
Alina Austin	2010
Joan Grant	2010*/

-- 14. First and last names of authors that wrote books in more than one genre
-- Creates a whole name 
SELECT Concat(a.AuthorFirstName, ' ', a.AuthorLastName) as Name, Count(Book.Genre) as GenreCount
FROM Author as a
-- Joins Book
INNER JOIN Book
ON a.authorid = book.authorid
-- Sums by name
GROUP BY Name
-- Makes sure genre count is over 1
HAVING Count(DISTINCT Book.Genre) > 1
-- outputs genres with highest counts first
ORDER BY GenreCount DESC
;

-- Results
/*
*/


