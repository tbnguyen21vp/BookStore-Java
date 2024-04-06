CREATE PROCEDURE AddBook(
    IN bookTitle VARCHAR(255), 
    IN bookPrice DOUBLE, 
    IN bookVolume BIGINT, 
    IN authorName VARCHAR(255), 
    IN categoryName VARCHAR(255), 
    IN publisherName VARCHAR(255)
)
BEGIN
    DECLARE authorID BIGINT DEFAULT 0;
    DECLARE categoryID BIGINT DEFAULT 0;
    DECLARE publisherID BIGINT DEFAULT 0;
    DECLARE existingBookID BIGINT DEFAULT 0;

    -- Kiểm tra xem sách có tồn tại hay không dựa trên tiêu đề
    SELECT bookID INTO existingBookID FROM book WHERE title = bookTitle LIMIT 1;
    IF existingBookID = 0 THEN
        -- Kiểm tra và thêm mới tác giả nếu cần
        SELECT authorID INTO authorID FROM author WHERE name = authorName LIMIT 1;
        IF authorID = 0 THEN
            INSERT INTO author (name, status) VALUES (authorName, TRUE);
            SET authorID = LAST_INSERT_ID();
        END IF;

        -- Kiểm tra và thêm mới thể loại nếu cần
        SELECT categoryID INTO categoryID FROM category WHERE name = categoryName LIMIT 1;
        IF categoryID = 0 THEN
            INSERT INTO category (name, status) VALUES (categoryName, TRUE);
            SET categoryID = LAST_INSERT_ID();
        END IF;

        -- Kiểm tra và thêm mới nhà xuất bản nếu cần
        SELECT publisherID INTO publisherID FROM publisher WHERE name = publisherName LIMIT 1;
        IF publisherID = 0 THEN
            INSERT INTO publisher (name, status) VALUES (publisherName, TRUE);
            SET publisherID = LAST_INSERT_ID();
        END IF;

        -- Thêm sách mới
        INSERT INTO book (title, price, status, volume, publisherID, categoryID, authorID) 
        VALUES (bookTitle, bookPrice, TRUE, bookVolume, publisherID, categoryID, authorID);
    ELSE
        -- Thông báo lỗi hoặc xử lý nếu tiêu đề sách đã tồn tại
        SELECT 'Book title already exists' AS ErrorMessage;
    END IF;
END;


--(bookTitle, bookPrice, bookVolume, authorName, categoryName, publisherName)
-- 
CALL AddBook('Book 199', 10000, 1, 'Author 1', 'Category 1', 'Publisher 1');

