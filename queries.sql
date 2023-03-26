-- Part 1: Test it with SQL
--under “Part 1”, list the columns and their data types in the table as a SQL comment.
    SELECT * FROM job;
--
-- Part 2: Test it with SQL
--this works in my SQL workbench?

--from test
--("SELECT\\s+name\\s+FROM\\s+employer\\s+WHERE\\s+location\\s+=\\s+\"St.\\s+Louis\\s+City\";

SELECT name FROM employer WHERE location ="St. Louis City";

-- Part 3: Test it with SQL

DROP TABLE job;

-- Part 4: Test it with SQL