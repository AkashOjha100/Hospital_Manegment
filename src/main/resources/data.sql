INSERT INTO patient
(name, email, gender, birth_date, blood_group, created_at)
VALUES
    ('Akash Kumar', 'akash.kumar@gmail.com', 'MALE',
     '2001-07-15 00:00:00', 'O_POSITIVE', NOW()),

    ('Riya Sharma', 'riya.sharma@gmail.com', 'FEMALE',
     '2002-03-10 00:00:00', 'A_POSITIVE', NOW()),

    ('Vikash Ojha', 'vikash.ojha@gmail.com', 'MALE',
     '2000-11-22 00:00:00', 'B_NEGATIVE', NOW()),

    ('Neha Verma', 'neha.verma@gmail.com', 'FEMALE',
     '1999-05-18 00:00:00', 'AB_POSITIVE', NOW()),

    ('Rahul Singh', 'rahul.singh@gmail.com', 'MALE',
     '2001-01-05 00:00:00', 'O_NEGATIVE', NOW());


INSERT INTO doctor(name,specialization,email)
VALUES
    ('Dr.Vinod Mehta','Cardiology','vinod@gmail.com'),
    ('Dr.Akash','Orthopedics','akash321@gmail.com');