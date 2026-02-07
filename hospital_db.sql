CREATE TABLE staff (
    staff_id SERIAL PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    age INTEGER NOT NULL,
    phone VARCHAR(50) NOT NULL,
    staff_type VARCHAR(20) NOT NULL,
    specialization VARCHAR(100) NOT NULL,
    experience_years INTEGER NOT NULL,
    disease VARCHAR(100) NOT NULL,
    admitted BOOLEAN DEFAULT FALSE
);

CREATE INDEX idx_staff_type ON staff(staff_type);
CREATE INDEX idx_staff_name ON staff(full_name);

-- Test Doctors
INSERT INTO staff (full_name, age, phone, specialization, experience_years, staff_type)
VALUES
    ('Dr. Nursultan', 45, '87011234567', 'Cardiology', 20, 'DOCTOR'),
    ('Dr. Aigul', 38, '87017654321', 'Neurology', 12, 'DOCTOR');

-- Test Patients
INSERT INTO staff (full_name, age, phone, disease, admitted, staff_type)
VALUES
    ('Madi', 30, '87010001122', 'Flu', TRUE, 'PATIENT'),
    ('Dana', 25, '87013334455', 'Covid-19', FALSE, 'PATIENT');


-- Verify data
SELECT * FROM staff ORDER BY staff_id;

-- Count all staff
SELECT COUNT(*) as total_staff FROM staff;

-- Get only doctors
SELECT * FROM staff WHERE staff_type = 'DOCTOR';

-- Get only patients
SELECT * FROM staff WHERE staff_type = 'PATIENT';

-- Get experienced doctors (> 5 years)
SELECT * FROM staff WHERE staff_type = 'DOCTOR' AND experience_years > 5 ORDER BY experience_years DESC;

-- Get admitted patients
SELECT * FROM staff WHERE staff_type = 'PATIENT' AND admitted = TRUE;

-- Average experience of doctors
SELECT AVG(experience_years) as avg_experience, COUNT(*) as total_doctors
FROM staff
WHERE staff_type = 'DOCTOR';
