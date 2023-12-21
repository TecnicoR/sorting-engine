package org.sortingengine.model;

/**
 * The User record represents a simple user entity with an ID and a name. It is designed to be used for testing various
 * sorting algorithms within the SortingEngine class. As a record, User provides an efficient and concise way to
 * represent immutable data, ideal for sorting based on different attributes like ID or name.
 *
 * <p>Attributes of the User record:</p>
 * <ul>
 *     <li>{@code int id}: An integer ID field to uniquely identify a user.</li>
 *     <li>{@code String name}: A String field representing the user's name.</li>
 * </ul>
 *
 * <p>Since User is defined as a record, it automatically provides implementations of
 * {@code equals()}, {@code hashCode()}, and {@code toString()} methods that are based on
 * the record's state.</p>
 */
public record User( int id, String name ) {
}
