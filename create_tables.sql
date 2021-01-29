CREATE TABLE machine (
	machine_id integer UNIQUE PRIMARY KEY,
	brand VARCHAR NOT NULL,
	model VARCHAR NOT NULL,
	tonnage INTEGER NOT NULL,
	tie_bar_horizontal INTEGER NOT NULL,
        tie_bar_vertical INTEGER NOT NULL,
        platten_horizontal INTEGER NOT NULL,
        platten_vertical INTEGER NOT NULL,
        mold_height_min INTEGER NOT NULL,
        mold_height_max INTEGER NOT NULL,
        shot_size_pe INTEGER NOT NULL,
        shot_size_ps INTEGER NOT NULL,
        date_added TIMESTAMP
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

INSERT INTO machine (machine_id, brand, model, tonnage, tie_bar_horizontal, tie_bar_vertical, platten_horizontal, platten_vertical, mold_height_min, mold_height_max, shot_size_pe, shot_size_ps, date_added) 
VALUES(18, 'Shibaura Machine', 'EC55SXIII', 55, 410, 360, 510, 460, 150, 370, 63, 50, CURRENT_TIMESTAMP);

INSERT INTO machine (machine_id, brand, model, tonnage, tie_bar_horizontal, tie_bar_vertical, platten_horizontal, platten_vertical, mold_height_min, mold_height_max, shot_size_pe, shot_size_ps, date_added) 
VALUES(19, 'MILACRON', 'Roboshot', 55, 360, 320, 500, 470, 210, 410, 57, 46, CURRENT_TIMESTAMP);



