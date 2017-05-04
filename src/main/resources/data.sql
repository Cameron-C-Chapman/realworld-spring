insert into articles
  (title, slug, body, description, author_id)
  values
  ('title', 'slug', 'body', 'description', 1)
;

insert into users
  (email, username, password, image, bio)
  values
  ('user1@mail.com', 'user1', 'userPassword', 'user1ImageUrl', 'user1BioUrl')
;

insert into favorites
  (user_id, article_id)
  values
  (1, 1)
;

insert into follows
(follower_user_id, following_user_id)
values
  (1, 1)
;