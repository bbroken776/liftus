CREATE TABLE
    user_roles (
        user_id BIGINT NOT NULL,
        roles VARCHAR(255) NOT NULL,
        PRIMARY KEY (user_id, roles),
        FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
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
VALUES
    (
        1,
        2,
        'Agata',
        'Gomes',
        'admin',
        'admin@liftus.pt',
        '$2a$10$jpLNVNeA7Ar/ZQ2DKbKCm.MuT2ESe.Qop96jipKMq7RaUgCoQedV.'
    );

INSERT INTO
    user_roles (user_id, roles)
VALUES
    (1, 'USER');

INSERT INTO
    user_roles (user_id, roles)
VALUES
    (2, 'USER');

INSERT INTO
    user_roles (user_id, roles)
VALUES
    (2, 'ADMIN');