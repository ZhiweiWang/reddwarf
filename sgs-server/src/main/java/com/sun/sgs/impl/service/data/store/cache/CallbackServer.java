/*
 * Copyright 2007-2009 Sun Microsystems, Inc.
 *
 * This file is part of Project Darkstar Server.
 *
 * Project Darkstar Server is free software: you can redistribute it
 * and/or modify it under the terms of the GNU General Public License
 * version 2 as published by the Free Software Foundation and
 * distributed hereunder to you.
 *
 * Project Darkstar Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.sun.sgs.impl.service.data.store.cache;

import java.io.IOException;
import java.rmi.Remote;

/**
 * Defines the network interface for requests to downgrade or evict items from
 * a node's cache.
 */
public interface CallbackServer extends Remote {

    /**
     * Requests that the node downgrade access to an object from write access
     * to read access.  If the method returns {@code true}, then the object has
     * been downgraded as requested.  If the method returns false, then the
     * node will arrange to call {@link UpdateQueue#downgradeObject} to notify
     * the server that it has downgraded the object.
     *
     * @param	oid the object ID
     * @param	nodeId the ID of the node requesting the downgrade
     * @return	{@code true} if the object has been downgraded as requested, or
     *		else {@code false} if the downgrade is delayed
     * @throws	IOException if a network problem occurs
     */
    boolean requestDowngradeObject(long oid, long nodeId) throws IOException;

    /**
     * Requests that the node give up access to an object.  If the method
     * returns {@code true}, then the object has been evicted as requested.  If
     * the method returns false, then the node will arrange to call {@link
     * UpdateQueue#evictObject} to notify the server that it has evicted the
     * object.
     *
     * @param	oid the object ID
     * @param	nodeId the ID of the node requesting the eviction
     * @return	{@code true} if the object has been evicted as requested, or
     *		else {@code false} if the eviction is delayed
     * @throws	IOException if a network problem occurs
     */
    boolean requestEvictObject(long oid, long nodeId) throws IOException;

    /**
     * Requests that the node downgrade write access to a name binding from
     * write access to read access.  If the method returns {@code true}, then
     * the name binding has been downgraded as requested.  If the method
     * returns false, then the node will arrange to call {@link
     * UpdateQueue#downgradeBinding} to notify the server that it has
     * downgraded the name binding.
     *
     * @param	name the name
     * @param	nodeId the ID of the node requesting the downgrade
     * @return	{@code true} if the name binding has been downgraded as
     *		requested, or else {@code false} if the downgrade is delayed
     * @throws	IOException if a network problem occurs
     */
    boolean requestDowngradeBinding(String name, long nodeId)
	throws IOException;

    /**
     * Requests that the node give up access to a name binding.  If the method
     * returns {@code true}, then the name binding has been evicted from the
     * node's cache as requested.  If the method returns false, then the node
     * will arrange to call {@link UpdateQueue#downgradeBinding} to notify the
     * server that it has evicted the name binding.
     *
     * @param	name the name
     * @param	nodeId the ID of the node requesting the eviction
     * @return	{@code true} if the name binding has been evicted as
     *		requested, or else {@code false} if the eviction is delayed
     * @throws	IOException if a network problem occurs
     */
    boolean requestEvictBinding(String name, long nodeId) throws IOException;
}
