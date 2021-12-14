CREATE TABLE photo_storage_properties
(
    photo_storage_id integer NOT NULL,
    user_id integer NOT NULL,
    file_name varchar(950) NOT NULL,
    file_format varchar(150) NOT NULL,
    uploadDirectory TEXT NOT NULL,
    PRIMARY KEY (photo_storage_id)
);