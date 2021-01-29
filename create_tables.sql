CREATE TABLE machine (
	machine_id integer UNIQUE PRIMARY KEY,
	brand VARCHAR NOT NULL,
	model VARCHAR NOT NULL,
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

CREATE TABLE tool (
        tool_id INTEGER UNIQUE PRIMARY KEY,
        client_name VARCHAR,
        width INTEGER NOT NULL,
        height INTEGER NOT NULL,
        stack INTEGER NOT NULL,
        shot_size INTEGER NOT NULL
);

CREATE TABLE assignments (
        quote_id serial PRIMARY KEY,
        client_name VARCHAR,
        machine_id INTEGER,
        tool_id INTEGER,
        date_assigned TIMESTAMP,
        constraint fk_assignment_tool foreign key (tool_id) references tool(tool_id),
        constraint fk_assignment_machine foreign key (machine_id) references machine(machine_id)
);

