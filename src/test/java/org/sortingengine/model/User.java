package org.sortingengine.model;

import java.util.Objects;

import org.sortingengine.algo.SortingEngine;

/**
 * The User class represents a simple user entity with an ID and a name. It is designed to be used for testing various
 * sorting algorithms within the SortingEngine class. The User class provides necessary fields and methods to facilitate
 * sorting based on different attributes like ID or name.
 *
 * <p>This class includes:
 * <ul>
 *     <li>An integer ID field to uniquely identify a user.</li>
 *     <li>A String name field representing the user's name.</li>
 * </ul>
 *
 * <p>Additionally, the class overrides equals and hashCode methods to ensure
 * proper comparison and functioning in collections.</p>
 *
 * @see SortingEngine
 */
public class User {
  private final int id;
  private final String name;

  public User( int id, String name ) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  // Override equals and hashCode for proper comparison in tests
  @Override
  public boolean equals( Object o ) {
    if( this == o )
      return true;
    if( o == null || getClass() != o.getClass() )
      return false;
    User user = (User) o;
    return id == user.id && Objects.equals( name, user.name );
  }

  @Override
  public int hashCode() {
    return Objects.hash( id, name );
  }
}
