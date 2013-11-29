java-wordpress-api
==================

A Java library for creating posts and getting some basic information from a Wordpress installation using its
[XML-RPC API][xmlrpc].

The library currently supports the minimum information to allow a Jenkins plugin to post to a Wordpress installation.
Therefore it supports creating a post, querying for available categories, tags and post types.

## Basic Usage

```java
  Post post = new Post("Title of post", "Content for posting");

  WordpressClient client = new WordpressClient();
  String newPostId = client.newPost(post);
```

## Building the Java Wordpress API

A Maven POM is provided with the library.

To build and install the library:

```shell
  mvn install
```

## Using the library in your project

The release versions of the library are deployed to Github which means you will need to add a repository to your Maven POM:

```xml
  <repositories>
    <repository>
      <id>java-wordpress-api-mvn-repo</id>
      <url>https://raw.github.com/ashri/java-wordpress-api/mvn-repo/</url>
      <snapshots>
        <enabled>true</enabled>
        <updatePolicy>always</updatePolicy>
      </snapshots>
    </repository>
  </repositories>
```

You can then reference the library in your own Maven POM using the following:

```xml
  <dependencies>
    <dependency>
      <groupId>com.tearsofaunicorn.wordpress</groupId>
      <artifactId>wordpress-xmlrpc-client</artifactId>
      <version>1.0-SNAPSHOT</version>
    </dependency>
  </dependencies>
```

## Copyright

Copyright (c) 2013 Ashley Richardson. See [LICENSE][] for details.

[license]: https://github.com/ashri/java-wordpress-api/blob/master/LICENSE.md
[xmlrpc]: http://codex.wordpress.org/XML-RPC_WordPress_API