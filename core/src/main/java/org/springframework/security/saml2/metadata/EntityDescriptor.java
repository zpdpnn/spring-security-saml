/*
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.springframework.security.saml2.metadata;

import javax.xml.crypto.dsig.XMLSignature;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.security.saml2.Saml2Object;

/**
 * EntityDescriptor as defined in
 * <a href="https://www.oasis-open.org/committees/download.php/35391/sstc-saml-metadata-errata-2.0-wd-04-diff.pdf">
 *     Line 466-494
 * </a>
 */
public interface EntityDescriptor extends Saml2Object {
    String getID();

    String getEntityId();

    /**
     *
     * @return the timestamp of the metadata expiration date. null if this value has not been set.
     */
    DateTime getValidUntil();

    /**
     * The time interval in format "PnYnMnDTnHnMnS"
     * <li>
     *   <ul>P indicates the period (required)</ul>
     *   <ul>nY indicates the number of years</ul>
     *   <ul>nM indicates the number of months</ul>
     *   <ul>nD indicates the number of days</ul>
     *   <ul>T indicates the start of a time section (required if you are going to specify hours, minutes, or seconds)</ul>
     *   <ul>nH indicates the number of hours</ul>
     *   <ul>nM indicates the number of minutes</ul>
     *   <ul>nS indicates the number of seconds</ul>
     * </li>
     * @return the cache duration for the metadata. null if no duration has been set.
     */
    String getCacheDuration();

    List<XMLSignature> getSignatures();

    /**
     * Transforms {@link #getCacheDuration()} into milli seconds.
     * @return returns the number of milli seconds this metadata should be cached for. -1 if the value is not set.
     */
    long getCacheDurationMillis();

    List<ProviderDescriptor> getProviderDescriptors();
}