## Users
### GET /api/users: Retrieve all users
### GET /api/users/{userId}: Get user details
### POST /api/users: Create a new user
**Payload**
~~~
Content-Type: application/json
{
    "username": "new_username",
    "first-name": "my_name",
    "second-name": "my_surname",
    "work-experience": "work_experience",
    "email": "new_email@example.com",
    "password": "new_password",
}
~~~
### PATCH /api/users/{userId}: Update user information (authentication required)
**Payload**
~~~
Content-Type: application/json
Authorization: Bearer <token>
{
    "username": "new_username",
    "first-name": "my_name",
    "second-name": "my_surname",
    "work-experience": "work_experience",
    "email": "new_email@example.com",
    "password": "new_password",
}
~~~
### POST /api/login: Login into an existing user account
~~~
{
    "email": "new_email@example.com"
    "password": "new_password",
}
~~~
### POST /api/logout : Log out of user account (authentication required)
~~~
{
  Authorization: Bearer <token>
}
~~~
### DELETE /api/users/{userId}: Delete a user (authentication required)
**Payload**
~~~
Authorization: Bearer <token>
~~~

## Posts
### GET /api/posts?page=0&size=5: Retrieve posts
### GET /api/posts/{postId}: Retrieve a specific post
### POST /api/posts: Create a new post (authentication required)
**Payload**
~~~
Content-Type: application/json
Authorization: Bearer <token>
{
    "title": "Post Title",
    "content": "Post Content"
}
~~~
### PATCH /api/posts/{postId}: Update a specific post (authentication required)
**Payload**
~~~
Content-Type: application/json
Authorization: Bearer <token>
{
    "title": "Post Title",
    "content": "Post Content"
}
~~~
### GET /api/posts/{postId}/comments?page=0&size=10: Retrieve comments for a specific post
### DELETE /api/posts/{postId}: Delete a specific post (authentication required)
**Payload**
~~~
Authorization: Bearer <token>
~~~
## Comments
### POST /api/posts/{postId}/comments: Add a new comment to a specific post (authentication required)
**Payload**
~~~
Content-Type: application/json
Authorization: Bearer <token>
{
    "content": "Comment Content"
}
~~~
### PATCH /api/comments/{commentId}: Update a comment (authentication required)
**Payload**
~~~
Content-Type: application/json
Authorization: Bearer <token>s
{
    "content": "Updated Comment Content"
}
~~~
### DELETE /api/comments/{commentId}: Delete a comment(authentication required)
**Payload**
~~~
Host: example.com
Authorization: Bearer <token>
~~~


<table border="1">
  <tr>
    <th>Role</th>
    <th>Permissions</th>
  </tr>
  <tr>
    <td>Moderator</td>
    <td>
      <ul>
        <li>All User permissions</li>
        <li>Delete or edit any post or comment</li>
        <li>Delete or edit any user account</li>
  </tr>
  <tr>
    <td>Admin</td>
    <td>
      <ul>
        <li>All User permissions</li>
        <li>Delete any post or comment</li>
      </ul>
    </td>
  </tr>
  <tr>
    <td>User</td>
    <td>
      <ul>
        <li>View posts and comments</li>
        <li>Create posts</li>
        <li>Create comments</li>
        <li>Edit own posts and comments</li>
  </tr>
  <tr>
    <td>Guest</td>
    <td>
      <ul>
        <li>View posts and comments</li>
      </ul>
    </td>
  </tr>
