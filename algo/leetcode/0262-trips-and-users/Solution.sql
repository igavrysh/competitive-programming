# Write your MySQL query statement below
WITH 
    valid_trips AS (
        SELECT
            T.status AS status,
            T.request_at AS request_at
        FROM
            Trips AS T
        LEFT JOIN Users AS C
            ON C.users_id = T.client_id
        LEFT JOIN Users AS D
            ON D.users_id = T.driver_id
        WHERE
            C.banned = 'No'
            AND D.banned = 'No'
            AND T.request_at BETWEEN "2013-10-01" AND "2013-10-03"
    )
SELECT
    request_at AS Day,
    ROUND(
        SUM(
            CASE 
                WHEN VT.status = 'cancelled_by_driver' OR VT.status = 'cancelled_by_client' 
                    THEN 1
                ELSE 0
            END
        ) / 
        SUM(1), 
        2
    ) AS `Cancellation Rate`
FROM
    valid_trips AS VT
GROUP BY 
    request_at
;
