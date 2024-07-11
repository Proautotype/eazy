create table category
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        varchar(255),
    description varchar(255)
);

create table inventory(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    quantity INT,
    inventory_status enum('IN_STOCK','OUT_OF_STOCK','NEEDS_REPLENISHMENT')
);

CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    price DECIMAL(19, 2),
    inventory_id BIGINT,
    category_id BIGINT,
    CONSTRAINT FK_inventory_id FOREIGN KEY (inventory_id) REFERENCES inventory (id),
    CONSTRAINT FK_category_id FOREIGN KEY (category_id) REFERENCES category (id)
);
