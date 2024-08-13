--------------------------------------------
--  Authentication and Authorization
-- (Tables used by the authentication and authorization system)
--------------------------------------------
BEGIN TRANSACTION;

drop table if exists users, user_roles, courses, review, message_board;
create table users (
    user_id serial primary key,
    username varchar(255),
    email varchar(255),
    password varchar(255)
    -- Additional fields can be added here,
    -- such as first name, last name, etc.
    -- Just also update the spring user model/dao
);

create table user_roles (
    username varchar(255),
    role varchar(255),
    primary key (username, role)
);

-- Create the admin/admin user with the ADMIN role
insert into users (username, password, email) values ('admin', '$2a$10$kRbQq1xPISiteFw/LMEoi.Cid/tKI4.flGJB.05hhtPpgIYu.LPbS', 'admin@example.com');
insert into user_roles (username, role) values ('admin', 'ADMIN');

--------------------------------------------
--  Application
-- (Tables used by the application)
--------------------------------------------

-- TODO: Add your tables here!
create table courses(
	course_id serial primary key,
	name varchar(100),
	city varchar(50),
	state varchar(50),
	designer varchar(75),
	open varchar(10),
	holes int,
	par int,
	length int,
	rating int,
	slope int
);

create table review(
	review_id serial primary key,
	course_id serial,
	course_name varchar(25),
	ranking int,
	condition varchar(250),
	value varchar(250),
	pace varchar(250),
	amenities varchar(250),
	difficulty varchar(250),
	CONSTRAINT fk_review
		FOREIGN KEY(review_id)
			REFERENCES users(user_id)
);
create table message_board(
	message_id serial primary key,
	title varchar(100),
	message varchar(500),
	user_id int,
	CONSTRAINT fk_user_id
		FOREIGN KEY(user_id)
			REFERENCES users(user_id)
);

INSERT INTO courses(name, city, state, designer, open, holes, par, length, rating, slope)
VALUES('White Clouds','Sun Valley','Idaho','Donald Knott','Public', 9, 36, 3605, 37.5, 145),
	   ('Trail Creek','Sun Valley', 'Idaho', 'Robert Trent Jones Jr.', 'Public', 18, 72, 6968, 72.5, 141),
	   ('Elkhorn','Sun Valley', 'Idaho', 'Robert Trent Jones Jr.','Public', 18, 72, 7214, 73.4, 136),
	   ('Bigwood','Ketchum', 'Idaho','Robert Muir Graves','Public', 9, 36, 3407, 35.8, 119),
	   ('Hazard Creek Golf Course', 'Aberdeen', 'Idaho', 'Unknown', 'Public', 9, 35, 2768, 34.8, 123),
	   ('American Falls Golf Course','American Falls','Idaho','Unknown', 'Public',9, 33, 2310, 32, 113),
	   ('Yellowstone Golf Resort At Aspen Acres','Ashton','Idaho', 'Unknown', 'Public',18,60,2992,50.5,73),
	   ('Timberline Golf','Ashton','Idaho','Unknown','Public',9,35,2131,null, null),
	   ('Fremont County Golf Course','Saint Anthony','Idaho','Unknown','Public',9,36,3151,35,122),
	   ('Blackfoot Golf Course', 'Blackfoot','Idaho','George Von Elm','Public', 18,72,6899,70.5,127),
	   ('Journeys End Golf Course','Shelley', 'Idaho','Unknown','Public',9,35,3025,null,null ),
		('Stoneridge Golf','Blanchard', 'Idaho','Jim Krause/Frank Burandt','Public',18,71,6684,70.6,124),
		('Twin Lakes Village Golf Course','Rathdrum','Idaho','William G. Robinson','Public',18,72,6277,70,121),
		('The Links Golf Club','Post Falls','Idaho','Emmett Burley','Public',18,73,7400,73.6,123),
		('Avondale Golf Club','Hayden Lake','Idaho','Melvin Hueston','Public',18,74,6573,77.8,142),
		('Mirror Lake Golf Course','Bonners Ferry','Idaho','Edward A. Hunnicutt','Public',9,36,2885,34.2,121),
		('Hillcrest Country Club','Boise','Idaho','A. Vernon Macan','Private',18,72,6769,72,128),
		('Crane Creek Country Club','Boise', 'Idaho','Bob E. Baldock','Private',18,71,7107, 74.1, 140),
		('Warm Springs Golf Course','Boise','Idaho','J.D. Evans','Public',18,72,6719,70.9,115),
		('Quail Hollow Golf Course', 'Boise','Idaho',' Bruce Devlin/Robert von Hagge','Public',18,70,6373,70.7,129),
		('Indian Lakes Golf Club','Boise','Idaho','Unknown','Public',9,35,3093,71.5,117),
		('The River Club','Boise','Idaho','Unknown','Private',18,71,6376,69.5,120),
		('Pierce Park Greens','Boise','Idaho','Dennis Labrum','Public',9,27,900,35,113);







INSERT INTO review(course_name, ranking, condition, value, pace, amenities, difficulty)
VALUES('Elkhorn',4,'The greens were slow and they recently aerated them.','Expensive but great!','Average','Food at the turn - no cart people.','challenging!');

INSERT INTO message_board(title, message)
VALUES('Looking for a 4th golfer this Friday', 'Hi Crew! I had a buddy drop out for our round of 18 this Friday. Anyone interested - give me a call!'),
('Golf Trip','Does anyone want to plan a golf trip to Arizona this winter?'),
('Advice for a beginner','New to golf! Are there any quick tips or tricks that I should know from the start?'),
('Best golf courses in the states?','I want to hear all your opinions on the best courses in the US');

COMMIT;
