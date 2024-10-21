INSERT INTO
    users (
        version,
        id,
        first_name,
        last_name,
        username,
        email,
        password
    )
VALUES
    (
        1,
        1,
        'Filipe',
        'Guedes',
        'user',
        'user@liftus.pt',
        '$2a$10$xdbKoM48VySZqVSU/cSlVeJn0Z04XCZ7KZBjUBC00eKo5uLswyOpe'
    );

INSERT INTO
    users (
        version,
        id,
        first_name,
        last_name,
        username,
        email,
        password
    )
values
    (
        1,
        2,
        'Sameen',
        'Shawn',
        'driver',
        'driver@liftus.pt',
        '$2b$12$WZAqlPaXBim68sd8JPZJ5.EL7p.KP40YDWTRtIZ/wsh3R5XRqb72W'
    );

INSERT INTO
    users (
        version,
        id,
        first_name,
        last_name,
        username,
        email,
        password
    )
VALUES
    (
        1,
        3,
        'Agata',
        'Gomes',
        'admin',
        'admin@liftus.pt',
        '$2a$10$jpLNVNeA7Ar/ZQ2DKbKCm.MuT2ESe.Qop96jipKMq7RaUgCoQedV.'
    );

INSERT INTO
    user_entity_roles (user_entity_id, roles)
VALUES
    (1, 'USER');

INSERT INTO 
    user_entity_roles (user_entity_id, roles)
VALUES
    (2, 'DRIVER');

INSERT INTO
    user_entity_roles (user_entity_id, roles)
VALUES
    (3, 'USER');

INSERT INTO
    user_entity_roles (user_entity_id, roles)
VALUES
    (3, 'ADMIN');