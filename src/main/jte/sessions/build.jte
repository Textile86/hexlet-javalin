@import org.example.hexlet.model.NamedRoutes

<form action="${NamedRoutes.sessionsPath()}" method="post">
    <div>
        <label>
            Nickname
            <input type="text" name="nickname" />
        </label>
    </div>>
    <div>
        <label>
            Password
            <input type="text" name="password" />
        </label>
    </div>
    <input type="submit" value="Sign In" />
</form>