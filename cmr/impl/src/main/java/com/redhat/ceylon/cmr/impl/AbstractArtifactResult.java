/*
 * Copyright 2011 Red Hat inc. and third party contributors as noted 
 * by the author tags.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.redhat.ceylon.cmr.impl;

import java.io.File;

import com.redhat.ceylon.cmr.api.ArtifactContext;
import com.redhat.ceylon.cmr.api.ArtifactResult;
import com.redhat.ceylon.cmr.api.ArtifactResultType;
import com.redhat.ceylon.cmr.api.ImportType;
import com.redhat.ceylon.cmr.api.PathFilter;
import com.redhat.ceylon.cmr.api.Repository;
import com.redhat.ceylon.cmr.api.RepositoryException;
import com.redhat.ceylon.cmr.api.VisibilityType;

/**
 * Abstract artifact result.
 *
 * @author <a href="mailto:ales.justin@jboss.org">Ales Justin</a>
 */
public abstract class AbstractArtifactResult implements ArtifactResult {

    private String name;
    private String version;

    private volatile File artifact;
    private volatile boolean checked;

    private PathFilter filter;
    
    private Repository repository;

    protected AbstractArtifactResult(Repository repository, String name, String version) {
        this.name = name;
        this.version = version;
        this.repository = repository;
    }

    public String name() {
        return name;
    }

    public String version() {
        return version;
    }

    public ImportType importType() {
        return ImportType.UNDEFINED;
    }

    public VisibilityType visibilityType() {
        if (type() == ArtifactResultType.CEYLON) {
            File file = artifact();
            if (file != null && file.getName().endsWith(ArtifactContext.CAR)) {
                return VisibilityType.STRICT;
            }
        }
        return VisibilityType.LOOSE;
    }

    public File artifact() throws RepositoryException {
        if (artifact == null && checked == false) {
            checked = true;
            artifact = artifactInternal();
        }
        return artifact;
    }

    protected abstract File artifactInternal();

    public PathFilter filter() {
        return filter;
    }

    protected void setFilterInternal(PathFilter filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return "[Artifact result: " + name + "/" + version + "]";
    }

    @Override
    public Repository repository() {
        return repository;
    }

    @Override
    public ArtifactContext getSiblingArtifact(String... suffixes) {
        return new ArtifactContext(name, version, repository, suffixes);
    }
    
}

