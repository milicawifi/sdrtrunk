/*******************************************************************************
 * sdrtrunk
 * Copyright (C) 2014-2016 Dennis Sheirer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 ******************************************************************************/
package audio.broadcast.icecast;

import audio.broadcast.BroadcastConfiguration;
import audio.broadcast.BroadcastFormat;
import audio.broadcast.BroadcastServerType;
import audio.broadcast.broadcastify.BroadcastifyConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso( {BroadcastifyConfiguration.class } )
public class IcecastTCPConfiguration extends IcecastConfiguration
{
    private final static Logger mLog = LoggerFactory.getLogger( IcecastTCPConfiguration.class );

    public IcecastTCPConfiguration()
    {
        this(BroadcastFormat.MP3);
    }

    /**
     * Icecast 2.3.x and 2.4.x compatible configuration
     * @param format of audio
     */
    public IcecastTCPConfiguration(BroadcastFormat format)
    {
        super(format);
    }

    @Override
    public BroadcastConfiguration copyOf()
    {
        IcecastTCPConfiguration copy = new IcecastTCPConfiguration(getBroadcastFormat());

        //Broadcast Configuration Parameters
        copy.setName(getName());
        copy.setHost(getHost());
        copy.setPort(getPort());
        copy.setPassword(getPassword());
        copy.setDelay(getDelay());
        copy.setEnabled(false);

        //Icecast Configuration Parameters
        copy.setUserName(getUserName());
        copy.setMountPoint(getMountPoint());
        copy.setDescription(getDescription());
        copy.setGenre(getGenre());
        copy.setPublic(isPublic());
        copy.setURL(getURL());

        return copy;
    }

    @Override
    public BroadcastServerType getBroadcastServerType()
    {
        return BroadcastServerType.ICECAST_TCP;
    }
}
