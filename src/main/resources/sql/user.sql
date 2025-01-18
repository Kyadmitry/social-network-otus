insert_user=INSERT INTO users (id, first_name, last_name, birth_date, gender, interests, city, email, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)

select_user_by_id=SELECT * FROM users WHERE id=?

select_user_by_email=SELECT * FROM users WHERE email=?
