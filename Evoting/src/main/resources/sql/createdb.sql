-- name and password are same word.
INSERT INTO APP.users (username,password)  VALUES('rajesh','973d7f9efc06ba81112bceb8205309ff0f49c303c28914a1dcf143d86a1b15b4');
INSERT INTO APP.users (username,password)  VALUES('ashok','19404ce9e897c60dde098e25d85dece4f4a6f36b4cc58d805f582d9cea14e6eb');
INSERT INTO APP.users (username,password)  VALUES('hem','d4a0ffcc990b5a1341cc261f330efe9b38ecf5af644bfda4ac2b17fbaaf999e6');
INSERT INTO APP.users (username,password)  VALUES('admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918');
INSERT INTO APP.users (username,password)  VALUES('user','04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb');

INSERT INTO APP.groups (username,groupname) VALUES('admin','admin');
INSERT INTO APP.groups (username,groupname) VALUES('rajesh','admin');
INSERT INTO APP.groups (username,groupname) VALUES('ashok','user');
INSERT INTO APP.groups (username,groupname) VALUES('hem','user');
