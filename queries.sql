-- Part 1: Test it with SQL
--under “Part 1”, list the columns and their data types in the table as a SQL comment.
    SELECT * FROM job;
--
-- Part 2: Test it with SQL
--this works in my SQL workbench?
--from test
--("SELECT\\s+name\\s+FROM\\s+employer\\s+WHERE\\s+location\\s+=\\s+\"St.\\s+Louis\\s+City\";

SELECT name FROM employer WHERE location = "St. Louis City";


-- Part 3: Test it with SQL

DROP TABLE job;

-- Part 4: Test it with SQL

--from test
--"SELECT\\s+\\*\\s+FROM\\s+skill" +
--                "\\s*(LEFT|INNER)?\\s+JOIN\\s+job_skills\\s+ON\\s+(skill.id\\s+=\\s+job_skills.skills_id|job_skills.skills_id\\s+=\\s+skill.id)" +
--                "(\\s*WHERE\\s+job_skills.jobs_id\\s+IS\\s+NOT\\s+NULL)?" +
--                "\\s*ORDER\\s+BY\\s+name\\s+ASC;"

SELECT * FROM skill
LEFT JOIN job_skills on skill.id = job_skills.skills_id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY name ASC;