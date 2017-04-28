create table articles (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR2(255) NOT NULL,
  slug VARCHAR2(255) UNIQUE NOT NULL,
  body VARCHAR2 NOT NULL,
  description VARCHAR2(2048),
  favorite_count INT DEFAULT 0,
  author_id BIGINT NOT NULL,
  created_at DATETIME NOT NULL DEFAULT NOW(),
  updated_at DATETIME DEFAULT NOW()
);

create table comments (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  article_id BIGINT NOT NULL,
  created_at DATETIME NOT NULL DEFAULT NOW(),
  updated_at DATETIME DEFAULT NOW()
);

create table favorites (
  user_id BIGINT NOT NULL,
  article_id BIGINT NOT NULL,
  created_at DATETIME NOT NULL DEFAULT NOW(),
  updated_at DATETIME DEFAULT NOW()
);

create table follows (
  follower_user_id BIGINT NOT NULL,
  following_user_id BIGINT NOT NULL,
  created_at DATETIME NOT NULL DEFAULT NOW(),
  updated_at DATETIME DEFAULT NOW()
);

create table tags (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  tag VARCHAR2(64) NOT NULL UNIQUE,
  created_at DATETIME NOT NULL DEFAULT NOW(),
  updated_at DATETIME DEFAULT NOW()
);

create table article_tags (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  article_id BIGINT NOT NULL,
  created_at DATETIME NOT NULL DEFAULT NOW(),
  updated_at DATETIME DEFAULT NOW()
);

create table users (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  email VARCHAR2(128) NOT NULL UNIQUE,
  username VARCHAR2(128) NOT NULL UNIQUE,
  password VARCHAR2(256) NOT NULL,
  image VARCHAR2(2048),
  bio VARCHAR2,
  created_at DATETIME NOT NULL DEFAULT NOW(),
  updated_at DATETIME DEFAULT NOW()
);