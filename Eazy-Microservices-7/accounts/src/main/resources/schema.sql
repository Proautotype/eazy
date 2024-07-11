
CREATE TABLE IF NOT EXISTS customer (
    customer_id CHAR(36) DEFAULT (uuid()),
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    mobile_number VARCHAR(20) NOT NULL,
    created_at DATE NOT NULL,
    created_by VARCHAR(20) NOT NULL,
    updated_at DATE DEFAULT NULL,
    updated_by VARCHAR(20) DEFAULT NULL,
    PRIMARY KEY(customer_id)
);

CREATE TABLE IF NOT EXISTS accounts (
    account_number CHAR(36) DEFAULT (uuid()),
    customer_id CHAR(36) NOT NULL,
    account_type VARCHAR(100) NOT NULL,
    branch_address VARCHAR(200) NOT NULL,
    created_at DATE NOT NULL,
    created_by VARCHAR(20) NOT NULL,
    updated_at DATE DEFAULT NULL,
    updated_by VARCHAR(20) DEFAULT NULL,
    PRIMARY KEY(account_number),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

