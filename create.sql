create table userevent (
  id serial primary key,
  name text,
  event text
);

create table usertime (
  id serial primary key,
  date date,
  time time
);

create table events_happens (
  id serial primary key,
  event_id int not null references userevent(id),
  time_id int not null references usertime(id)
);