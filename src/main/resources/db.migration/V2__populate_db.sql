INSERT INTO client (name) VALUES
('Client1'),
('Client2'),
('Client3'),
('Client4'),
('Client5'),
('Client6'),
('Client7'),
('Client8'),
('Client9'),
('Client10');
INSERT INTO planet (id, name) VALUES
('MARS', 'Mars'),
('VEN', 'Venus'),
('EARTH', 'Earth'),
('JUPITER', 'Jupiter'),
('SATURN', 'Saturn');
INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
(1, 'MARS', 'EARTH'),
(2, 'VEN', 'MARS'),
(3, 'EARTH', 'JUPITER'),
(4, 'MARS', 'SATURN'),
(5, 'EARTH', 'VEN'),
(6, 'JUPITER', 'MARS'),
(7, 'SATURN', 'EARTH'),
(8, 'MARS', 'VEN'),
(9, 'VEN', 'SATURN'),
(10, 'JUPITER', 'EARTH');