CREATE TABLE `people` (
  `person_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NOT NULL,
  `passwd` VARCHAR(100) NOT NULL,
  `isAdmin` INT,
  PRIMARY KEY (`person_id`)
);

CREATE TABLE `movie` (
  `movie_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `genre` VARCHAR(100) NOT NULL,
  `studio` VARCHAR(100),
  `yr` INT,
  `director` VARCHAR(100),
  `isPublished` INT,
  `deleteRequest` INT,
  `editMovieID` INT,
  PRIMARY KEY (`movie_id`)
);

CREATE TABLE `comments` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `person_id` INT NOT NULL,
  `movie_id` INT NOT NULL,
  `comment` VARCHAR(500),
  PRIMARY KEY (`comment_id`)
);

CREATE TABLE `ratings` (
  `person_id` INT NOT NULL,
  `movie_id` INT NOT NULL,
  `rating` DECIMAL,
  PRIMARY KEY (`person_id`)
);

CREATE TABLE `bookmarks` (
  `person_id` INT NOT NULL,
  `movie_id` INT NOT NULL,
  PRIMARY KEY (`person_id`)
);

ALTER TABLE `bookmarks` ADD FOREIGN KEY (`person_id`) REFERENCES `people` (`person_id`);

ALTER TABLE `ratings` ADD FOREIGN KEY (`person_id`) REFERENCES `people` (`person_id`);

ALTER TABLE `comments` ADD FOREIGN KEY (`person_id`) REFERENCES `people` (`person_id`);

ALTER TABLE `bookmarks` ADD FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`);

ALTER TABLE `ratings` ADD FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`);

ALTER TABLE `comments` ADD FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`);

