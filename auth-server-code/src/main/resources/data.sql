INSERT INTO oauth_client_details
    (client_id, client_secret, scope, authorized_grant_types,
     web_server_redirect_uri, authorities, access_token_validity,
     refresh_token_validity, additional_information, autoapprove)
VALUES
    ('clientId', 'clientSecret', 'scopeA,scopeB',
     'authorization_code,password,refresh_token', 'http://127.0.0.1:8091/oauth/callback', null, 3600, 864000, null, true);

INSERT INTO oauth_client_details
(client_id, client_secret, scope, authorized_grant_types,
 web_server_redirect_uri, authorities, access_token_validity,
 refresh_token_validity, additional_information, autoapprove)
VALUES
    ('clientId2', 'clientSecret2', 'scopeA,scopeB',
     'authorization_code,password,refresh_token', 'http://127.0.0.1:8091/oauth/callback', null, 3600, 864000, null, true);
