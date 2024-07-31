CREATE TABLE task(
    ID UUID PRIMARY KEY UNIQUE NOT NULL,
    task VARCHAR(120),
    description VARCHAR(200),
    date_initial_task TIMESTAMP NOT NULL,
    date_final_task TIMESTAMP NOT NULL
)