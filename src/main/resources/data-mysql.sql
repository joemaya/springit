insert into link (id, creation_date, last_modified_date, created_by, last_modified_by, title, url)
values ( '1', NOW(), NOW(), null, null, 'Getting started with spring boot 2' , 'https://therealdanavega.com/spring-boot-2');

insert into comment (id, creation_date, last_modified_date, created_by, last_modified_by, body, link_id)
values ( '1', NOW(), NOW(), null, null, 'What an awesome idea for course' , 1);