SELECT * FROM role;
INSERT INTO role (role) VALUE ("ADMIN");

SELECT * FROM user;
INSERT INTO user (password, username, is_account_non_expired, is_account_non_locked,is_credentials_non_expired, is_enabled) VALUES ("$2a$10$qbjz212GvIGsREaki5E/BemsNzyCmfyshUhj6SJtrrEWfu9yy1U0y", "admin", true, true, true, true);

SELECT * FROM user_role;
INSERT INTO user_role VALUES (1,1);

SELECT username, password FROM user WHERE user.username="user";
SELECT role FROM ROLE
	INNER JOIN user_role ON (Role.ID = USER_ROLE.role_id)
    INNER JOIN user ON (user_role.user_id=user.user_id)
    WHERE Role.role = user.username;