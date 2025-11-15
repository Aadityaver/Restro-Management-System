CREATE TABLE IF NOT EXISTS staff (
    staff_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
   phone VARCHAR(15),
   role VARCHAR(20) NOT NULL,
     status VARCHAR(20) DEFAULT 'ACTIVE',
    restaurant_id BIGINT,
    user_id BIGINT
);
