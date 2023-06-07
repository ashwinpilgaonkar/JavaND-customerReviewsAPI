CREATE TABLE product (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price FLOAT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE review (
    id INT NOT NULL AUTO_INCREMENT,
    reviewer_name VARCHAR(150) NOT NULL,
    review_text VARCHAR(255) NOT NULL,
    stars INT NOT NULL,
    product_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE comment (
    id INT NOT NULL AUTO_INCREMENT,
    commenter_name VARCHAR(150) NOT NULL,
    comment_text VARCHAR(255) NOT NULL,
    review_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (review_id) REFERENCES review(id)
);