CREATE OR REPLACE FUNCTION insert_reservation(name varchar(1024), creator_id int, room_id int, v$begin_date timestamp,
                                              v$end_date timestamp) RETURNS boolean AS
$$
DECLARE
    overlapped int;
BEGIN
    -- проверить на пересечение по датам с другими резервированиями, если их нет, то добавить
    SELECT count(*)
    INTO overlapped
    FROM reservation r
    WHERE (r.begin_date, r.end_date) OVERLAPS (v$begin_date, v$end_date);
    -- IF
    -- INSERT INTO reservation
    RETURN true;
END ;
$$ LANGUAGE plpgsql;