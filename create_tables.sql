CREATE TABLE machine (
	machine_id integer UNIQUE PRIMARY KEY,
	brand VARCHAR ( 50 ) NOT NULL,
	model VARCHAR ( 50 ) NOT NULL,
	tonnage INTEGER NOT NULL,
	tie_bar_horizontal TIMESTAMP NOT NULL,
        tie_bar_vertical INTEGER NOT NULL,
        platten_horizontal INTEGER NOT NULL,
        platten_vertical INTEGER NOT NULL,
        mold_height_min INTEGER NOT NULL,
        mold_height_max INTEGER NOT NULL,
        shot_size_pe INTEGER NOT NULL,
        shot_size_ps INTEGER NOT NULL
);

CREATE TABLE assignments (
        quote_id serial PRIMARY KEY,
        tool_number serial,
        machine_id INTEGER,
        date_assigned TIMESTAMP
);